# Lab04

## Ex 1 questions

### a) Identify a couple of examples on the use of ArrertJ expressive methods chaining

Em **EmployeeRepositoryTest.java** usamos o import:

```java
import static org.assertj.core.api.Assertions.assertThat;
```
Ao longo dos testes desta classe podemos verificar o uso do método assertThat:

```java
assertThat( found ).isEqualTo(alex);
assertThat(fromDb).isNull();
assertThat(fromDb).isNotNull();
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
```
Também encontramos o uso destes métodos noutras classes como por exemplo no **EmployeeRestControllerTemplateIT.java**:

```java
assertThat(found).extracting(Employee::getName).containsOnly("bob");
assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
```

### b) Identify an example in which you mock the behavior of the repository (and avoid involving a database)

Em **EmployeeService_UnitTest.java** acontece isso, usamos o **Mockito** de forma a controlar os testes.

Nesta classe apenas usamos o **Junit** e o **Mockito**, não envolvendo a DB

```java
Employee alex = new Employee("alex", "alex@deti.com");
Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);

String name = "alex";
Employee found = employeeService.getEmployeeByName(name);
assertThat(found.getName()).isEqualTo(name);

```

### c) What is the difference between standard @Mock and @MockBean?

**@Mock** é usado quando a lógica é a base de **Unit Testing** (Apenas usando **JUnit** e **Mockito**)

**MockBean** é usado quando escrevemos um teste que é apoiado por um **Spring Test** e queremos adicionar ou substituir um **Bean** com uma versão mocked dele

### d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

O **application-integrationtest.properties** é usado para guardar algumas propriedades caso queiramos correr a aplicação noutro ambiente.

Em **Spring Boot** (neste caso) as propriedades são guardadas neste ficheiro, normalmente localizado na pasta **test/resources**.
