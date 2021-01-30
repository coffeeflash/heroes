# heroes
## Erweiterung:
Es gibt einen weiteren Microservice namens "ticketbooth", welcher die Endpoints; "/buyTicket" und "/checkTicket" zur Verfügung stellt.
Folgende TicketIds werden beim Start der App initalisiert (für die sogenannten Staffs):
* VIP001
* VIP002
* VIP003

Mit diesen Ticket Nummern kann man jederzeit einen Kampf bestaunen...
Andernfalls muss man eines kaufen gehen.

## Restart der Microservices
Ab undzu müssen die gewisse Services am Anfang restartet werden, resp. sie müssten wahrscheinlich in einer gewissen Reihgenfolge gestartet... Also wenn es Fehler gibt, dass ein Service nicht verfügbar ist, verpasste der in der Regel sich bei der Registry anzumelden.
