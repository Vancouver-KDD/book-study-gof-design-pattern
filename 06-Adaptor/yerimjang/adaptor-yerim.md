# Adaptor

### Intent
- lets classes **work together** that couldn't otherwise because of **incompatible interface**.

### Motivation
- A power plug adapter
![alt text](https://miro.medium.com/max/1400/1*gw2KaBMjy4x5k4FM1JRsRQ.png "Motivation 1")

- 3rd-party data/legacy code
![alt text](https://refactoring.guru/images/patterns/diagrams/adapter/problem-en-2x.png?id=f6f4bfbd2d6136a5ae4fb8c899e9854e "Motivation 2")


### Consequences
> A class adapter
- can be implemented using **multiple inheritance**.
- won't work when we want to adapt a class and all its subclasses.
- lets Adapter **override some of Adaptee's behavior**, since Adapter is a subclass of Adaptee.
> An object adaptor
- lets a single Adapter work with **many Adaptees**.
- requires **subsclassing Adaptee** and making Adapter refer to the subclass rather than the Adaptee itself.
- can change the Adaptee dynamically in run-time.

### Sample Code
- A class adapter
[C++ Example](https://refactoring.guru/design-patterns/adapter/cpp/example#example-1)
~~~java
class Adaptee {
    public void show() {
        System.out.println("Adaptee method show()");
    }
}

interface Target {
    void display();
}

class MyNewClassAdapter extends Adaptee implements Target {
    @Override
    public void show() {
      System.out.println("MyNewClassAdapter method show()");
    }

    public void display() {
        show();
    }
}
~~~
>MyNewClassAdapter method show()

- An object adapter
~~~java
class Adaptee {
    public void show() {
        System.out.println("Adaptee method show()");
    }
}

interface Target {
    void display();
}

class MyNewObjectAdapter implements Target {

    private Adaptee adaptee;

    public MyNewObjectAdapter(Adaptee adaptee) {
      this.adaptee = adaptee;
    }

    public void display() {
        adaptee.show();
    }
}
~~~
>Adaptee method show()

### Reference
- https://refactoring.guru/design-patterns/adapter
- https://levelup.gitconnected.com/design-patterns-structural-patterns-of-design-classes-and-objects-79d58a6519b
- https://refactoring.guru/design-patterns/adapter/cpp/example#example-1
