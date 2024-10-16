const express = require('express');
const { Client } = require('pg');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 3000;

// PostgreSQL client setup
const client = new Client({
    connectionString: 'postgres://postgres:postgres@db:5432/firozdb'
});
//client.connect();
client.connect()
    .then(() => console.log('Connected to PostgreSQL'))
    .catch(err => console.error('Connection error', err.stack));

// Example query to test connection
client.query('SELECT * FROM employees')
    .then(res => console.log(res.rows))
    .catch(err => console.error('Query error', err.stack));

app.use(express.static(path.join(__dirname, 'public')));
app.use(bodyParser.json());

// Endpoint to get list of tables
app.get('/tables', async (req, res) => {
    try {
        const result = await client.query(`
            SELECT table_name 
            FROM information_schema.tables
            WHERE table_schema = 'public'
            ORDER BY table_name;
        `);
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error fetching tables' });
    }
});

// Endpoint to execute SQL query
app.post('/execute', async (req, res) => {
    const { query } = req.body;
    try {
        const result = await client.query(query);
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Error executing query' });
    }
});

// Serve the main HTML page
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}/`);
});
