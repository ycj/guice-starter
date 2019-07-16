import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Module

interface Vehicle{
    fun action()
}

class FrogMobile: Vehicle{
    override fun action() {
        println("Car run ...")
    }
}

class TestModule: Module{
    override fun configure(binder: Binder) {
        binder.bind(Vehicle::class.java).to(FrogMobile::class.java)
    }
}

fun main(){
    val injector = Guice.createInjector(TestModule())
    val obj = injector.getInstance(Vehicle::class.java)
    obj.action()
}