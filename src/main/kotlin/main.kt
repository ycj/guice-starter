import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Module

interface Verticle{
    fun action()
}

class Car: Verticle{
    override fun action() {
        println("Car run ...")
    }
}

class TestModule: Module{
    override fun configure(binder: Binder?) {
        binder?.bind(Verticle::class.java).to(Car::class.java)
    }
}

fun main(){
    val injector = Guice.createInjector(TestModule())
    val obj = injector.getInstance(Verticle::class.java)
    obj.action()
}