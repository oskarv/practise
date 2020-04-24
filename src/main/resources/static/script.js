console.log("Hello World");

// a.	Variable scope
// global variable is visible in and out the function, but local variable is visible just in the function
var globalVariable = "global";

function visibilityFunction() {
    var localVariable = "local";
    console.log("Variable scope in the function: " + globalVariable);
    console.log("Variable scope in the function: " + localVariable);
}

visibilityFunction();

console.log("Variable scope out of the function: " + globalVariable);

// b.	Undefined vs null in JS
// null means an empty or non-existent value; it is typeof object
// undefined means a variable has been declared without value; it is typeof undefined
// null !== undefined
// null == undefined
var nullVariable = null;
console.log(nullVariable);
console.log(typeof nullVariable);

var undefinedVariable;
console.log(undefinedVariable);
console.log(typeof undefinedVariable);

// c.	Callbacks and High-Order functions
// callback
function callback() {
    console.log("Function has been called.");
}

function doSomething(functionToCall) {
    console.log("Calling the function...");
    functionToCall();
}

doSomething(callback);

// high-order
function createMultiplier(factor) {
    function multiplier(number) {
        return number * factor;
    }

    return multiplier;
}

var multiplierByTwo = createMultiplier(2);
console.log("High-Order: " + multiplierByTwo(10));

var multiplierByFive = createMultiplier(5);
var multiplierByThree = createMultiplier(3);
console.log("High-Order: " + multiplierByFive(multiplierByThree(2)));

// d.	Closure
function closureFunction() {
    var closure = "Closure";

    function showClosure() {
        console.log("Closure: " + closure);
    }

    return showClosure;
}

var test = closureFunction();
test();

// e.	This keyword in JS and f.	Creating objects in JS
var person = {
    firstName: "Anja",
    lastName: "Radenovic",
    getFullName: function () {
        return this.firstName + " " + this.lastName;
    }
};

console.log("This keyword: " + person.getFullName());
console.log("Object person: " + person.firstName);

// g.	Prototype and inheritance
function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

function Professor(firstName, lastName, subject) {
    Person.call(this, firstName, lastName);
    this.subject = subject;
}

function Student(firstName, lastName, index) {
    Person.call(this, firstName, lastName);
    this.index = index;
}

Professor.prototype = Object.create(Person.prototype);
Student.prototype = Object.create(Person.prototype);

Person.prototype.greet = function () {
    return `${this.firstName} says hello.`;
};

Professor.prototype.teach = function () {
    return `${this.firstName} teaches ${this.subject}.`;
};

Student.prototype.enroll = function () {
    return `${this.firstName} enrolls under index ${this.index}.`;
};

var personProfessor = new Professor("Oskar", "Vatic", "JavaScript");
var personStudent = new Student("Anja", "Radenovic", 123);
console.log(personProfessor);
console.log(personStudent);

// h.	Apply, call and bind methods
// apply and call invoke the function
// call pass arguments which are comma separated list, but apply pass arguments which are in an array
// bind returns a function

// call
var person1 = {firstName: "Milica", lastName: "Micic"};
var person2 = {firstName: "Milos", lastName: "Micic"};

function greatPersonCall(text) {
    console.log(`${text} ${this.firstName} ${this.lastName}`);
}

greatPersonCall.call(person1, "Hello");
greatPersonCall.call(person2, "Hello");

//apply
var person3 = {firstName: 'Nemanja', lastName: 'Petrovic'};

var greetPerson = function (argument1, argument2) {
    return "Hello " + this.firstName + " welcome to " + argument1 + " " + argument2 + "!";
};

var arguments = ["company", "Endava"];
console.log(greetPerson.apply(person3, arguments));

// bind
var bound = greetPerson.bind(person3);
console.log(bound);
console.log(bound("company", "Endava"));

// i.	Hoisting
// declaration is move to the top
example = 5;
var example;
console.log(example);