import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.model.TableStatus;


tablename="my-favorite-movies-table";

dynamoDB = new AmazonDynamoDBClient(new ClasspathPropertiesFileCredentialsProvider());
euWest1 = Region.getRegion(Regions.EU_WEST_1);
dynamoDB.setRegion(euWest1);

scanRequest = new ScanRequest().withTableName(tablename);

result = dynamoDB.scan(scanRequest);
for (item in result.getItems()){ println(item); }



/*
hashKeyCondition = new Condition();
hashKeyCondition.withComparisonOperator(ComparisonOperator.EQ.toString());
hashKeyCondition.withAttributeValueList(new AttributeValue().withS("Airplane"));

keyConditions = new HashMap<String, Condition>();
keyConditions.put("name", hashKeyCondition);

queryRequest = new QueryRequest();
queryRequest.withTableName(tablename);
queryRequest.withKeyConditions(keyConditions);

result = dynamoDB.query(queryRequest);
for (item : result.getItems()) { println(item); }
*/
