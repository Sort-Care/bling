# Bling: Ben's Lingo

This is a tiny language (a *lingo*) demonstrating JavaCUP.

# Setup

Run the following:
```bash
java -jar libs/java-cup-11b.jar -package "bling" -interface -parser "Parser" -destdir src/bling -expect 1 "bling.cup"
javac -g -cp libs/java-cup-11b-runtime.jar:. -d bin src/bling/*.java src/bling/exception/*.java
```

This will generate the parser and compile the interpreter. Note that you may
have to create the `bin` directory if it does not already exist:

```
mkdir bin
```

# Running

```bash
./bling program.bling arg1 arg2 arg3
```

So easy, right?

# The Language
Each program is a sequence of statements. Each statement is either
1. an assignment: `let ident = expr;`. `ident` must be an identifier (a, b2,
   c_3, etc (note here that etc is both a continuation, indicating that the
   reader may infer from the examples other instances of identifiers, but also
   is, in and of itself, an example of a valid identifier. This is not
   important and by reading this you have wasted several precious seconds of
   your life.))
2. an `if` statement: `if (cond) stmt1` or `if (cond) stmt1 else stmt2`. `cond`
   must be a `Bool`-typed expression (below)
3. a `while` loop: `while (cond) stmt`
4. a block: `{stmt1; stmt2; ... }`
5. a `print` statement: `print expr;`

## Expressions
Expressions are the valued entities in our language: they are those things that
we can ask "what is this thing's value?". Expressions are either typed `Int` or
`Bool`.

### Int Operators

The language supports basic arithmetic:

```
binop ::= expr + expr
       |  expr - expr
       |  expr * expr
       |  expr / expr
       |  expr % expr
unop ::= -expr
```

### Bool Operators

Standard and/or/nots apply

```
binop ::= expr & expr
       |  expr | expr
unop ::= !expr
```

### Misc Exprs

Parenthetical expressions are allowed as well

# This Repo
All meta-language (Java) code is located in `src/bling`. This describes the AST.
Example object-language (Bling) code is located in `example`. `libs` contains
JavaCUP, and `bling` is a shell script that runs the interpreter.
