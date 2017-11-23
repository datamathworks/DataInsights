package com.mathworks.example.scala.aalvin

object ScalaCookBookCh578 extends App {

  /* Methods */

  /* Scala scope options:
    • Object-private scope
    • Private
    • Package
    • Package-specific
    • Public */

  // Object-private scope
  //    - most restrictive access for a method
  //    - method only available to current instance of current object
  //    - other instances of same class cannot access the method
  private[this] def isFoo = true

  // Private scope
  //   - less restrictive
  //   - available to current class and instances of the current class
  private def isFoo1 = true

  // Protected scope
  //   - available to subclasses (through inheritance)
  class Animal {
    protected def breathe {}
  }
  class Dog extends Animal {
    breathe
  }

  // Package scope
  //  - available to all members of the current package
  // package com.acme.coolapp.model
  // private[model] def doX {}

  // Public scope - if no access modifier added to declaration, the method is public
  def doX {}


}
