# GitOps

## What is GitOps

"GitOps" started from a blog called [GitOps - Operations by Pull Request](https://www.weave.works/blog/gitops-operations-by-pull-request) by Alexis, one of the founders from WeaveWorks.

It talks about how to trigger system operations from git, how to define solution and operations as code, how to compare status of system with code, how to recover from system failure.

## What are the goals to use GitOps

If we talk about the goal of GitOps in one sentence, it is all about to make life easier.

With a complete solution of GitOps:

1. Developers only push the code to git and all following steps such as unit test, integration test, code scans, deployment and etc. should happen automatically.
2. Operators are aware of configuration changes by comparing it with git repository infrastructure definitions.
3. Complete solution can be deployed from scratch within few minutes, without human interfere.

## How to apply this methodology
GitOps has 3 essential parts, IaC (Infrastructure as Code), CI (Continuous Integration) and CD (Continuous Deployment)

GitOps is a philosophy, it does not have dedicated toolset. We can use terraform for IaC, jenkins for CI/CD orchestration and Istio on Kubernetes for Canary deployment, A/B test and etc. scenarios.

### Scenarios

- **Automate Infrastructure Setup**
  Instead of manually create development/staging/production environment, you should be able to map the "code" to the infrastructure.
- **Service Canary Update**
  Each single service can be updated automatically and without downtime.
- **Service Failover/Rollback**
  When software failure happens in the environment, it can rollback the system to previous stable version.

### IaC with terraform
Below is an short introduction on how to deploy Alibaba Cloud  container service with terraform.
- **Documents**

    If you are relatively fresh for Cloud or Alibaba Cloud. you can find the official website of [Alibaba Cloud](https://www.alibabacloud.com/). It shares similar concept of how to manage cloud resources as other cloud providers, by using VPC(Virtual Private Cloud), Security Group and the various managed services.

    I assume you have already some knowledge or information about [terraform](https://www.terraform.io/). Here is the [official terraform document for Alibaba Cloud](https://www.terraform.io/docs/providers/alicloud/index.html) as well as the [container service topic](https://www.terraform.io/docs/providers/alicloud/r/cs_kubernetes.html) under this category.

- **Code Explanation**


