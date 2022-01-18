package bg.softuni.kotlin.service

interface GreeterService {
  fun greeting(person: String = "Anonymous") : String
}
