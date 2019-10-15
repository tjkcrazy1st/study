var express = require('express');
var router = express.Router();
var AWS = require("aws-sdk");
AWS.config.update({
  region: "us-west-2",
  endpoint: "http://localhost:8000",
  accessKeyId:"myAccessKey",
  secretAccessKey:"fakeSecretKey"
});
var docClient = new AWS.DynamoDB.DocumentClient();
router.get('/', function(req, res, next) {


  console.log("Querying for movies from 1985.");
  var params = {
    TableName : "Movies",
    KeyConditionExpression: "#yr = :yyyy",
    ExpressionAttributeNames:{
      "#yr": "year"
    },
    ExpressionAttributeValues: {
      ":yyyy": 1985
    }
  };

  docClient.query(params, function(err, data) {
    if (err) {
      console.error("Unable to query. Error:", JSON.stringify(err, null, 2));
    } else {
      console.log("Query succeeded.");
      data.Items.forEach(function(item) {
        console.log(" -", item.year + ": " + item.title);
      });
      res.render('index', { title: 'Demo load movies to bigdata', list: data.Items });
    }
  });
});
module.exports = router;
