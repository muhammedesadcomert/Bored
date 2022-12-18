# 🥱 Bored

Bored is a simple Android app written with Jetpack Compose that helps you find things to do when bored.

## ⚡ Technologies & Open-Source Libraries

- [Kotlin](https://kotlinlang.org/) - Google officially supports Kotlin on Android as a “first-class” language and it has a [a lot of benefits](https://developer.android.com/kotlin).
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - A coroutine is a concurrency design pattern that can use on Android to simplify code that executes asynchronously.
- [Flow](https://kotlinlang.org/docs/flow.html) - An asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android’s recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
- [MVVM Architecture](https://developer.android.com/topic/architecture#recommended-app-arch) - Modern, maintainable, and Google-suggested app architecture.
- Android Architecture Components - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform an action when lifecycle state changes.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in the data layer that contains application data and business logic.
    - [UseCase](https://developer.android.com/topic/architecture/domain-layer#use-cases-kotlin) - Located domain layer that sits between the UI layer and the data layer.
- Dependency Injection
    - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Easy implementation and less boilerplate code than Dagger2.
- Networking
    - [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
    - [OkHttp](https://square.github.io/okhttp/) - An HTTP client that efficiently make network requests.
- [Composable Sweet Toast](https://github.com/tfaki/ComposableSweetToast) - A library that you can use in 4 different types (Success, Error, Warning, Info) written with Jetpack Compose. You can use this toast easy. *Thanks for this [Talha](https://github.com/tfaki).*

## Package Structure

```
bored             # Root package
|
├─ data           # Data layer
│  ├─ dto         # Data transfer objects for remote response
│  ├─ network     # BoredApi
│  ├─ repository  # Bored Repository
|
├─ di             # Dependency-injection module
│  ├─ coroutine   # Coroutine Dispatcher module
|
├─ domain         # Domain layer
│  ├─ entity      # UI models
│  ├─ mapper      # Map Dto to domain models
│  ├─ usecase     # BoredActivity usecases
|
├─ ui             # Presentation layer
│  ├─ component   # Custom components
│  ├─ home        # Main screen
│  ├─ theme       # Colors, typography and theme options
|
├─ util           # Utility classes/interfaces
```

## License

```
MIT License

Copyright (c) 2022 Muhammed Esad Cömert

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
