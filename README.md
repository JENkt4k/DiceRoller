# DiceRoller Android Jenkins Pipeline Example

This project is an example project taken from the the Udacity [Google Android Fundementals course](https://www.udacity.com/course/new-android-fundamentals). This project has been modified to inlcude a Jenkinsfile for a CICD pipeline. This is a WIP example of how to install, configure, create and deploy multiple packages from multiple languages using Kubernetes, Docker, Jenkins, Andoird Lint, and eventually other tools (ex: SonarQube, Appium, etc.)

## First example (current)
OS: Windows 10 x64

Computer: Acer Predator Helios 500 i7 Intel, Nvidia GTX 1070, 64 GB Ram, 2.5 TB SSD (1.5) and HDD (1)

Tools: Docker Desktop, Kubernetes (installed via Docker Desktop), docker-compose Jenkins/BlueOcean Docker container, CirclCI/Android-29-node Docker container

Jenkins plugins:
- Android Lint
- Jenkins Lint



## References

[Run an Android emulator on docker](https://medium.com/@AndreSand/android-emulator-on-docker-container-f20c49b129ef)

[Android Docker Images from CircleCI](https://github.com/CircleCI-Public/circleci-dockerfiles)
- running Android emulator in [CircleCI](https://fovea.cc/blog/index.php/circleci-calabash/) 
- [Jenkins vs CircleCI](https://medium.com/@sandeepqaops/circleci-appium-android-emulators-not-exactly-a-match-made-in-heaven-938110612f4d)

[Appium](http://appium.io/)
- [Appium Docker Image](https://hub.docker.com/r/appium/appium/)