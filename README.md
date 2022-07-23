# Coroutines
- defines scope eg GlobalScope.launch {}
- inside scope you can suspend for some time by calling delay(3000L)
- if main thread finishes its work all threads will stop
- Suspend functions can only be called within a coroutine or another suspend function
- Suspend functions execute sequentially within a coroutine unless other wise
