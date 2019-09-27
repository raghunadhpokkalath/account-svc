var URL = 'http://localhost:8080/api/';

var request = require('supertest').agent(URL);
var assert = require('assert');

exports.request = request;
exports.assert = assert;