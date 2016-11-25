# A demo for anti-pattern: calling overridable methods in a constructor

## Introduction

When a @Override method is invoked within a constructor, the state of the object may be inconsistent and/or incomplete.

A quote from Effective Java 2nd Edition, Item 17: Design and document for inheritance, or else prohibit it:

> There are a few more restrictions that a class must obey to allow inheritance. Constructors must not invoke overridable methods, directly or indirectly. If you violate this rule, program failure will result. The superclass constructor runs before the subclass constructor, so the overriding method in the subclass will be invoked before the subclass constructor has run. If the overriding method depends on any initialization performed by the subclass constructor, the method will not behave as expected.

In this simple app, it tries to demonstrate the order of object initialization: 

super constructor &rarr; overridable method(if it's called in the super constructor) &rarr; subclass instance variable initialization &rarr; sbuclass constructor   

## The application

There are 2 classes, Parent and Child. Child extends Parent. In the constructor of Parent, it calls init() method, which is overridden in Child.

The init method takes parameter from the constructor, when it's bigger than 0.5, the likely is set to true.

It seems working, until we might decide to set an initial value to the Child.likely field like:
```java
	private boolean likely=false;
```
We might expect that shouldn't change anything since we are just assigning the initial value to the field, which will be changed in the object initialization process later. But actually this assignment runs after the construction of its super class, which calls the init() method. That means it runs after the init(), which makes all the value false.

As a good practice: never call overridable methods in constructors
 

## References
[What's wrong with overridable method calls in constructors?](http://stackoverflow.com/questions/3404301/whats-wrong-with-overridable-method-calls-in-constructors)
