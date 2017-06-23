package com.example.koltinDemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


//数据类
@Entity
data class Customer(
        var firstName: String = "",
        var lastName: String = "",
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int = 0
)

//数据库操作
interface CustomRepository: CrudRepository<Customer, Long> {
    fun findByLastName(name: String): List<Customer>
}

//控制器
@RestController
class CustomerController @Autowired constructor(val repository: CustomRepository) {
    @RequestMapping("/")
    fun findAll() = repository.findAll()

    @RequestMapping("/{name}")
    fun findByLastName(@PathVariable name: String) = repository.findByLastName(name)
}

@SpringBootApplication
class KoltinDemoApplication {
    @Bean
    fun init(repository: CustomRepository): CommandLineRunner {
        return CommandLineRunner {
            repository.save(Customer("123", "lzp"))
            repository.save(Customer("Jack", "Bauer"))
            repository.save(Customer("Chloe", "O'Brian"))
            repository.save(Customer("Kim", "Bauer"))
            repository.save(Customer("David", "Palmer"))
            repository.save(Customer("Michelle", "Dessler"))
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KoltinDemoApplication::class.java, *args)
}


