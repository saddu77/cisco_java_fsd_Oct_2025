//Create a REST API in Node.js to add and list students
const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(bodyParser.json());

let students = [];

// Endpoint to add a student
app.post('/students', (req, res) => {
    const student = req.body;
    students.push(student);
    res.status(201).send({ message: 'Student added successfully', student });
});

// Endpoint to list all students
app.get('/students', (req, res) => {
    res.status(200).send(students);
});

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});