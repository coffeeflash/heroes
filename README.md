# heroes

## Postman Collection
In dem Wurzelverzeichnis findet sich eine PostmanCollection mit allen Calls und richtigen Ports und Defaultparametern.
Auch der neu eingeführte ***Ticketbooth Service*** und seine Features sind darin enthalten.
## Erweiterung:
Es gibt einen weiteren Microservice namens "ticketbooth", welcher die Endpoints; "/buyTicket" und "/checkTicket" zur Verfügung stellt.
Folgende TicketIds werden beim Start der App initalisiert (für die sogenannten Staffs):
* VIP001
* VIP002
* VIP003

Mit diesen Ticket Nummern kann man jederzeit einen ***bezahlten*** Kampf bestaunen...
Andernfalls muss man eines kaufen gehen.

Der microservice ***Promoter*** wurde mit einem weiteren endpoint ausgestattet; "/promotePaidFight". 
Im Genensatz zu dem default "/promoteFight", muss bei diesem Call eine Ticketnummer mitgegeben werden, welche dann in der Ticketbooth überprüft wird.
Ist die Nummer in der Datenbank, wird der bezahlte Kmapf lanciert, sonst wird darauf hingewisen dass ein valides Ticket bezogen werden muss. Wird keine Ticketnummer mitgegeben, wirft der Promoter eine Exception :)

Der PaidFight startet ein ganzes Tournament an Kämpfen...

```java
@GetMapping(value = "/promotePaidFight")
public String promotePaidFight(@RequestParam String ticketId) {
        if(ticketboothClient.checkTicket(ticketId)){
            String result = "The Promoter is proud to " +
                "proclaim the following result of today's ----paid---- tournament\n";
            for (int i = 0; i < 3; i++) {
                result += "Fight " + i + ": " + promoterService.promoteFight()+ " \n";
        }
            return result;
        }else{
            return "Sorry, you have to buy a valid ticket at the ticket booth first";
        }
}
 ```

## Challenges / Surprises

### Versionen

Mit dem Springinitalizer schmuggelten sich hier und da mal Versionen rein, welche Sie nicht verwendeten,
was anfänglich ein bisschen verwirrend war. 

### Microservices hinzufügen

Mich überraschte die Einfachheit, wie weitere Services hinzugefügt und verknüpft werden können. 
Allgemein hat das Spring Framework in seiner Gesamtheit überzeugt. Die Möglichkeiten scheinen immens und die PRoduktivität kann mit gezieltem Einsatz bestimmt verbessert werden.
Ich (Tobias) arbeite auch mit Spring in einem Unternehmen, wo ich dank diesem Modul auch motiviert bin ein bisschen mehr Modularität in Form von Microservices in die Applikation zu bringen.

### Restart der Microservices
Ab undzu müssen die gewisse Services am Anfang restartet werden, resp. sie müssten wahrscheinlich in einer gewissen Reihgenfolge gestartet... Also wenn es Fehler gibt, dass ein Service nicht verfügbar ist, verpasste der in der Regel sich bei der Registry anzumelden.
