## First Steps
1. Define the application.properties to fit your current setup.
For example, we need to change the server port because the default
one is used by Jenkins. Check the file for details.
2. Create whatever model belongs to your database. In this case we
will use "User", so check that file. Be sure to tag it as @Entity
,so it get mapped to the database.

>Class need a constructor, blank constructor, getters, setters and toString()

Access the database through /h2-console and check the model do
exist on the database. There is other ways to create a table in
the database, like a sql file, but this one maps your needs.

The model use a few important tags:

`@Entity` `@Id` - To map the table and the Primary Key.

`@Column` - In case you want to specify the column.

Entity and Column allow you to use (name = "X") to change their names.

## Repositories

The second step in the process is to create the repository for the
User model. The repository is the place where the actual "actions" 
exist. The repository itself use two things:

`@Repository` and `EntityManager`

The entityManager gives access to a lot of methods to manage the database
entries. For example, you can use entityManager.merge() to add
things to the table.

>public void insert(User user) { entityManager.merge(user); }

The entityManager must be autowired. `@Autowired` means springboot
will find the correspondent `@Component` that links there and do the job.
The specific Autowired for this kind of components is `@PersistentContext`.

At the same time, if you expect to make changes to the database,
you need to add `@Transactional` to the file as well. A way
to do this automatically is through the CommandLineRunner, but 
that will not be covered in this project, as it's not needed.

## JPA Data
Until now, we have used plain JPA, but it can be made even easier
creating an interface. This interface will manage new methods for our
queries. For example, it will change insert for save.

The interface extends JpaRepository with the following syntax:

>extends JpaRepository< MODEL, TypeOfPrimaryKey (Float, Integer..)>

This interface is the one you Autowire to use methods in.

## Validation
Fields in the user model can use different tags to ensure validation.
For example, a field can have a `@Size (min = 2, message = "Should have at least 2
characters")` Including requirements and message in case of error.
There is a lot of properties, but one of the most important ones is
`@JsonProperty ("label")` as it converts the JSON label to whatever you want.
And the `@GeneratedValue` for our primary key.

## Original values
Sometimes (like in this project) you need some data to be available
on the in memory database from the beginning. For this case
we can use the data.sql file. It's important to know that we can,
and should, defer the database creation, so it applies what we need.

The sql file is created on the Resources folder.

## API creation
The API is on the UserJpaController, and it uses different tags
too. First one is `@RestController` to indicate it's the one
giving endpoints. Each method will have its own one specifying
route and method with `@GetMapping("/map")` for a Get, and so
on.



