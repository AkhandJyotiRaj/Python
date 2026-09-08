

class Animal:
    a = 5
    def speak(self):
        print(self.a)

class Dog(Animal):
    def speak(self):
        print(self.a)
        
obj = Dog()
obj.speak() 