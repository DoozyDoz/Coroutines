# Coroutines
- defines scope eg GlobalScope.launch {}
- inside scope you can suspend for some time by calling delay(3000L)
- if main thread finishes its work all threads will stop
- Suspend functions can only be called within a coroutine or another suspend function
- Suspend functions execute sequentially within a coroutine unless other wise
- Dispatchers given extra info to the context in which the coroutine runs
- Main dispature will run on the main thread, IO will do IO operations and network calls, Unconfined and Default(very long operations and tasks)
- withContext(Dispatcher.Main) will help us switch between threads for a particular coroutine
- a delay() in runBlocking() context will block the main thread but not in Dispatchers.Main context 
