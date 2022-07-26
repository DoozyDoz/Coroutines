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
- runBlocking will only Affect the main thread, other coroutine scopes launched inside it will run normally(Asyncronously) 
- Launching a coroutine always returns a `job` which can be saved in a val
- The `job.join()` will wait for the `job` to finish.
- `job.cancel()` will cancel the coroutine
- sometimes if for long running jobs the coroutine continues even after its canceled to prevent this check `isActive()`
- `withTimeout(3000L)` will cancel the job after 3 seconds
- To measure the time a block takes to excute use `measureTimeMillis{}`
- Use `launch{}` within a coroutine scope to start other coroutines(these will run asynchronously)
- Use `async{}` to return a result from a coroutine and get the result using `Job.await`
- Whenever your coroutine returns a result use `async{}`
- Use `lifecycleScope` in case you want the coroutine to run as long as its activity.
- Dont handle exeptions in coroutines like you do for non coroutine code, use `CoroutineExceptionHandler{_,throwable-> log(..)}` instead
- In a `SupervisorScope()` when one child coroutines fail the other coroutines continue as opposed to a `coroutineScope()` when if one fails the whole scope stops