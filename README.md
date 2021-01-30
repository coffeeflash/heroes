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

## Restart der Microservices
Ab undzu müssen die gewisse Services am Anfang restartet werden, resp. sie müssten wahrscheinlich in einer gewissen Reihgenfolge gestartet... Also wenn es Fehler gibt, dass ein Service nicht verfügbar ist, verpasste der in der Regel sich bei der Registry anzumelden.
