# aws-lambda-java-template

This can be used to create a simple java lambda function for AWS.

Build the lambda function with:
```bash
gradle clean build
```

The jar file will be created in the folder `build/libs`.

In order to deploy the lambda to AWS you have to create an IAM role.

In the AWS console, find your account id (click Support -> Support center).

Using the IAM console, create a role called: basic-lambda-role

With the policy (fix the account id part):

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Action": [
        "logs:CreateLogGroup",
        "logs:PutLogEvents",
        "logs:CreateLogStream"
      ],
      "Resource": "arn:aws:logs:*:<your account id>:*"
    }
  ]
}
```
NOTE: this policy is not a super good production ready policy since it allows
your lambda to add log events to any log group in cloud watch. But it is fine
for testing purposes.