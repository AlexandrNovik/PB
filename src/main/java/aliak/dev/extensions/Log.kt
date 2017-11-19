package aliak.dev.extensions

fun Any.log(message: String) {
    System.out.println("${this.javaClass.simpleName}: $message")
}