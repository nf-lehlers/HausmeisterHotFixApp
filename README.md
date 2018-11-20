# Der ITECH-Dropwizard-Beispielservice

## Allgemeine Hinweise
Dieser ITECH-Dropwizard-Beispielservice dient zum Veranschaulichen einiger grundlegenden
Funktionalitäten eines REST-Services mit Dropwizard.

Die Übungen bzw. die Skripte für die Übungen wurden auf Linux/Unix-Systemen erstellt und getestet. Es sind sinnvolle Anpassungen für Windows-Umgebungen vorzunehmen.

Wenn Sie Verbesserungen und Erweiterungen für diesen Beispielservice vornehmen möchten, freuen wir uns über Ihr Engagement. Bitte erstellen Sie dann einen Pull-Request.

## Importieren und starten des Services über Eclipse
Nutzen Sie für diese Übung folgende Anleitung: https://gitlab.com/itech_public/itech_dropwizard_example/blob/master/docs/den_beispielservice_starten.docx


# Die folgenden Übungen sind Verständnisübungen und nicht als verpflichtend anzusehen.

## Übung: Untersuchen Sie die Resourcen und die Header der HTTP-Antworten
1. Prüfen Sie den Inhalt der Ressource: itech/resources/HelloWorldResource.java .
Sie könne z. B. die Ressource http://localhost:18181/helloWorld/simpleTextString aufrufen. Rufen Sie jetzt die anderen vier
Pfade der Ressource auf. Hinweis: Parameter können Sie u. a. mit <URL-Ressource>?<Parameter>=<Wert> übergeben.
 Jeder weitere Parameter kann mit '&' angehängt werden. Beispiel: http://localhost:18181/helloWorld/simpleTextGreetings?name=heiko&gender=MALE
 Diskutieren Sie folgende Fragen: Wie werden die Status-Codes festgelegt? Wo ist die Business-Logik implementiert?

## Übung: Untersuchen/Erweitern der Ressource "HelloWorldJsonResource"
1. Öffnen Sie die Klasse itech.resources.HelloWorldJsonResource . Schauen Sie sich den Ressourcen-Pfad an und rufen Ihn auf.

## Übung: Prüfen Sie die Implementierung und Erweiterung des Clients
1. Öffnen Sie die Klasse itech.client.HelloWorldClient . Schauen Sie sich den Ressourcen-Pfad an und rufen Ihn auf.
2. Erläutern Sie einem Mitschüler oder eine Mitschülern, was bei dem Aufruf der Ressource passiert.
3. Erweitern Sie den Client so, dass die Ressource  itech.resources.HelloWorldResource#helloWorldGreetings konsumiert werden kann.

## Übung: Testen
1. Schauen Sie sich die Tests des Projektes an: src/test/java/itech . Es gibt einen HelloWorldJsonExampleTest und einen HelloWorldServiceTest. Wie unterscheiden sich diese Tests?
2. Implementieren Sie einen Integrationstest, bei dem der Service gestartet wird und ein Ressource aufgerufen wird.

### Übungen: Metriken, Threads, Healthcheck
1. Rufen Sie die URL http://localhost:18182 auf. Für welchen Szenarien sind die bereitgestellte Funktionalitäten denkbar? Diskutieren Sie  sinnvolle Einsatzmöglichkeiten für 'Metrics', 'Threads' und 'Healthcheck' anhand von Beispielen.

### Übung: Dropwizard-Speicherverbrauch
1. Starten Sie den Dropwizard Service. Nutzen Sie VisualVM und "monitoren" Sie die Größe und die Nutzung des Heap-Speichers. Sie können mit Hilfe des Skripts scripts/performance_test_resource.sh für ein wenig Aktivität des Services sogen. Was sind die Minimal- und Maximalwerte? In welchem durchschnittlichen Bereich liegen die Werte ca.?
2. Starten Sie den Service und begrenzen Sie den minimalen und maximalen Heap-Speicher. Prüfen Sie dazu das Skript: scripts/itechDropAppStart.sh . Nutzen Sie VisualVM und monitoren Sie die Größe und die Nutzung des Heap-Speichers. Sie können mit Hilfe des Skripts scripts/performance_test_resource.sh für ein wenig Aktivität des Services sogen. Was sind die Minimal- und Maximalwerte? In welchem durchschnittlichen Bereich liegen die Werte ca.?
3. Vergleichen Sie die Messwerte aus Aufgabe 1 und 2 dieser Übung. Sind die Messwerte Ihrer Meinung nach beachtenswert? Begründen Sie!
