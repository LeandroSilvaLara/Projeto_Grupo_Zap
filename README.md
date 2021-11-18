# Grupo Zap - Viva Real

<b>How to run locally</b>

To run the application you need an installed emulator or a connected smartphone.<br>
The app's minimum Api is 21, and the target is 30 <br>
To launch the application click on Run App (Shift + F10) and then choose the Device.


## Clean Architecture
![Kiku](https://user-images.githubusercontent.com/49800137/142410325-80149204-a378-4174-bd8a-d858eb2efc9e.png)


### ----------------------------------------------------------------------------------------------

## Android 3 Layers Architecture
![Kiku](readme-images/clean_architecture_reloaded_layers.png)

### ----------------------------------------------------------------------------------------------

## UI Layer: MVVM
![Kiku](readme-images/layer-communication.png)

### ----------------------------------------------------------------------------------------------

## Data Layer: Repository
![Kiku](readme-images/clean_archictecture_reloaded_repository.png)

## Technologies - [Dependencies.kt](buildSrc/src/main/java/Dependencies.kt) file
* Kotlin - As main language
* Coroutines - To write asynchronous code
* Koin - As Dependency Injection Framework
* Retrofit - For API calls
* Lifecycle ViewModel - To preserve the view model alive through android configuration changes.


## Junit Tests & Instrumentation
* Mockk library to mock junit tests

### ----------------------------------------------------------------------------------------------

### Why MVVM?

As alternative to MVP, MVVM takes advantage of the reactive programming to decrease the coupling between the presentation
and the business layer. In that case the same viewModel could be used in many screens.

