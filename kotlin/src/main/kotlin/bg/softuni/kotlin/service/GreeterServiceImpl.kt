package bg.softuni.kotlin.service

import org.springframework.stereotype.Service

@Service
class GreeterServiceImpl : GreeterService {

  override fun greeting(person: String): String {
    return "Hello, $person"
  }
}
