# BLing: Ben's Lingo

This is a tiny language (a *lingo*) demonstrating JavaCUP.

# Setup

To generate the parser and symbol source files (`parser.java` and `sym.java`
respectively), run

```bash
java -jar libs/java-cup-11b.jar -package "bling" -interface -parser "Parser" -destdir src/bling -expect 1 "bling.cup"<Paste>
```
from the root of the project.

Then, to compile, run

```bash
javac -g -cp libs/java-cup-11b-runtime.jar:. -d bin src/bling/*.java src/bling/exception/*.java
```
