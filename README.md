# ContactList_with_MVP
Project architect with MVP, Dagger2, RxAndroid, Retrofit2.

The Model-View-Presenter design pattern is a modern pattern to seperate the view from the underlying model. 


MVP is similar to other structural patterns for implementing separation of concerns, such as Model-View-Controller and Model-View-ViewModel. 

In MVP on Android, your activities and fragments typically act as the view objects by implementing a view interface, and handle interaction of the app with the user.

The view passes on user actions to the presenter, which handles the business logic and interaction with data repositories, such as a server API or database. 

The model layer consists of the objects that make up the content of the app.


Dependency injection using Dagger2 is a software design pattern focused on making our applications loosely coupled, extensible, and maintainable.

Reactive Extension is a combination of the best ideas from the Observer pattern, the Iterator pattern, and functional programming.

RxJava is a port from Netflix of the Reactive Extensions (Rx) to Java. RxJava was open sourced 2014 and is hosted at http://reactivex.io/.

In reactive programming the consumer reacts to the data as it comes in. This is the reason why asynchronous programming is also called reactive programming. Reactive programming allows to propagates event changes to registered observers.

RxAndroid is port for Android of RxJava.

