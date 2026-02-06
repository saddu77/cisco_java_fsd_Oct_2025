// Create unit tests for login API using Jest and Supertest

const request = require('supertest');
const app = require('./app'); // Assuming your Express app is exported from app.js

describe('POST /login', () => {
  it('should return 200 and a token for valid credentials', async () => {
    const res = await request(app)
      .post('/login')
      .send({
        username: 'validUser',
        password: 'validPassword'
      });
    
    expect(res.statusCode).toEqual(200);
    expect(res.body).toHaveProperty('token');
  });

  it('should return 401 for invalid credentials', async () => {
    const res = await request(app)
      .post('/login')
      .send({
        username: 'invalidUser',
        password: 'invalidPassword'
      });
    
    expect(res.statusCode).toEqual(401);
    expect(res.body).toHaveProperty('error', 'Invalid credentials');
  });

  it('should return 400 for missing username', async () => {
    const res = await request(app)
      .post('/login')
      .send({
        password: 'somePassword'
      });
    
    expect(res.statusCode).toEqual(400);
    expect(res.body).toHaveProperty('error', 'Username is required');
  });

  it('should return 400 for missing password', async () => {
    const res = await request(app)
      .post('/login')
      .send({
        username: 'someUser'
      });
    
    expect(res.statusCode).toEqual(400);
    expect(res.body).toHaveProperty('error', 'Password is required');
  });
});