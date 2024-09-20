package com;

public class CastingExample {

	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.sound();
		
		if (animal instanceof Dog) {
		    Dog dog = (Dog) animal;
		    dog.bark();
		    dog.sound();
		} else {
		    System.out.println("animal is not a Dog");
		}
	}

}
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Dog barks");
    }
}

