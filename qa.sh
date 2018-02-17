chmod -R 777 /home/gitlab-runner
cd /home/gitlab-runner/builds/fd533f80/0/bootcamp23/mycourse/src/TrainingSystemWeb_new/training_systemweb_new
npm install
npm run build
cd /home/gitlab-runner/builds/fd533f80/0/bootcamp23/mycourse


docker build -t $CI_REGISTRY_IMAGE:training-system-web-qa -f src/dockerfile_web_qa .
docker push $CI_REGISTRY_IMAGE:training-system-web-qa

docker stop training-system
docker rm training-system
docker rmi gdcgit.perficient.com:4567/bootcamp23/mycourse:training-system
docker pull gdcgit.perficient.com:4567/bootcamp23/mycourse:training-system
docker run -d -p 8090:8090 -w /training-system -v /home/perficient/.m2:/root/.m2 --name training-system gdcgit.perficient.com:4567/bootcamp23/mycourse:training-system mvn spring-boot:run -Drun.profiles=qa 

docker stop training-system-web-qa
docker rm training-system-web-qa
docker rmi gdcgit.perficient.com:4567/bootcamp23/mycourse:training-system-web-qa
docker pull gdcgit.perficient.com:4567/bootcamp23/mycourse:training-system-web-qa
docker run -d -p 8080:80 --name training-system-web-qa gdcgit.perficient.com:4567/bootcamp23/mycourse:training-system-web-qa
