# DiceRoller Android Jenkins Pipeline Example

This project is an example project taken from the the Udacity [Google Android Fundementals course](https://www.udacity.com/course/new-android-fundamentals). Modifications inlcude a Jenkinsfile for a CICD pipeline as wells as examples of how to install, configure, create and deploy multiple packages from multiple languages using Kubernetes, Docker, Jenkins, Andoird Lint, and eventually other tools (ex: SonarQube, Appium, etc.)

## Windows configuration
OS: Windows 10 x64

Computer: Acer Predator Helios 500 i7 Intel, Nvidia GTX 1070, 64 GB Ram, 2.5 TB SSD (1.5) and HDD (1)

Tools: [Docker Desktop](https://www.docker.com/products/docker-desktop), [Kubernetes](https://kubernetes.io/) (installed via [Docker Desktop](https://collabnix.com/kubernetes-dashboard-on-docker-desktop-for-windows-2-0-0-3-in-2-minutes/)), [docker-compose](https://docs.docker.com/compose/gettingstarted/) [Jenkins/BlueOcean](https://hub.docker.com/r/jenkinsci/blueocean) Docker container, [CirclCI/Android-29-node](https://hub.docker.com/r/circleci/android) [Docker container](https://circleci.com/docs/2.0/circleci-images/), [GOGs](https://gogs.io/) for [private git server on a RaspberryPi 3](https://www.techcoil.com/blog/setting-up-your-own-raspberry-pi-3-git-server-with-go-git-service-gogs-and-raspbian-stretch-lite/)

Other Images:
- [jenkins/blueocean](https://hub.docker.com/r/jenkins/blueocean)
- [circleci/android-29](https://hub.docker.com/r/circleci/android)

Jenkins plugins:
- [Android Lint](https://wiki.jenkins.io/display/JENKINS/Android+Lint+Plugin)
- Jenkins Lint



## References

[Kubernetes Dashboard](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
)
```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta6/aio/deploy/recommended.yaml
kubectl proxy
```

[Jenkins Pipeline](https://jenkins.io/doc/book/pipeline/docker/)

[Building an Android app with Docker](https://medium.com/@AndreSand/building-android-with-docker-8dbf717f54d4)

[Kotlin on Docker](https://blog.baens.net/posts/step-by-step-kotlin/)

[Run an Android emulator on Docker](https://medium.com/@AndreSand/android-emulator-on-docker-container-f20c49b129ef)

[Android Docker Images from CircleCI](https://github.com/CircleCI-Public/circleci-dockerfiles)
- running Android emulator in [CircleCI](https://fovea.cc/blog/index.php/circleci-calabash/) 
- [Jenkins vs CircleCI](https://medium.com/@sandeepqaops/circleci-appium-android-emulators-not-exactly-a-match-made-in-heaven-938110612f4d)

[Appium](http://appium.io/)
- [Appium Docker Image](https://hub.docker.com/r/appium/appium/)

[Another RaspberryPi 3 tut](https://pimylifeup.com/raspberry-pi-gogs/)

[Another RaspberryPi 3 tut](https://dev.to/_lunacy_/private-github-with-gogs-and-raspberry-pi-46m3)

[Docker Jenkins Pipeline](https://medium.com/@hakdogan/an-end-to-end-tutorial-to-continuous-integration-and-continuous-delivery-by-dockerize-jenkins-f5b9b45b610d)