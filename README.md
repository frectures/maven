Maven löst 2 Probleme:

1. Dependency Management: benötigte Bibliotheken/Frameworks (und Maven-Plugins) werden automatisch heruntergeladen
2. Reproduzierbarer Build: unabhängig von der verwendeten/favorisierten Entwicklungsumgebung

Ein Maven-Projekt wird in der Datei `pom.xml` (*P*roject *O*bject *M*odel) konfiguriert.

Empfohlene Ordner-Struktur sowie Dateifluss zwischen den Ordnern innerhalb 6 wichtiger Phasen:

![](img/maven.svg)

Mavens Standard-Lebenszyklus teilt sich in 23 Phasen auf, von denen 8 mit Plugins vorbelegt sind:

| Phase                  | Plugin:Goal             | Bedeutung |
| ---------------------- | ----------------------- | --------- |
| process-resources      | resources:resources     | kopiert Produktiv-Ressourcen (z.B. Bilder oder Textdateien) |
| compile                | compiler:compile        | kompiliert produktiven Quelltext `Example.java` zu JVM-Bytecode `Example.class` |
| process-test-resources | resources:testResources | kopiert Test-Ressourcen |
| test-compile           | compiler:testCompile    | kompiliert Test-Quelltext `ExampleTest.java` zu JVM-Bytecode `ExampleTest.class` |
| test                   | surefire:test           | führt die Tests aus |
| package                | jar:jar / war:war       | komprimiert Produktiv-Klassen in ein `.jar` oder `.war` |
| install                | install:install         | kopiert das `.jar` in das lokale Maven-Repository |
| deploy                 | deploy:deploy           | kopiert das `.jar` in ein entferntes Maven-Repository |

Der Scope einer Dependency regelt ihre Verfügbarkeit zu 3 verschiedenen Zeitpunkten:

| `<scope>`  | compile | test    | runtime | Beispiele                  |
| ---------- | ------- | ------- | ------- | -------------------------- |
| `compile`  | &check; | &check; | &check; | Apache Commons, Guava      |
| `test`     |         | &check; |         | JUnit, Mockito, AssertJ    |
| `provided` | &check; | &check; |         | Servlet API, Java EE API   |
| `runtime`  |         | &check; | &check; | JDBC Treiber               |

Wenn man keinen expliziten Scope angibt, wird implizit `compile` verwendet.
