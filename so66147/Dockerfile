FROM r-base:3.6.3

SHELL ["/bin/bash", "-c"]
RUN apt-get update && apt-get install -y \
curl \
&& apt-get clean \
&& rm -rf /var/lib/apt/lists/*

RUN curl -s "https://get.sdkman.io" | bash \
&& source "$HOME/.sdkman/bin/sdkman-init.sh" \
&& sdk install java 8.0.252.hs-adpt \
&& sdk install maven 3.6.3

RUN source ~/.bashrc \
&& R CMD javareconf \
&& R CMD BATCH <(echo "install.packages('rJava')") \
&& mvn install:install-file -Dfile=/usr/local/lib/R/site-library/rJava/jri/JRI.jar -DgroupId=com.github.yukihane.rjava -DartifactId=jri -Dversion=0.1.0-SNAPSHOT -Dpackaging=jar \
&& mvn install:install-file -Dfile=/usr/local/lib/R/site-library/rJava/jri/JRIEngine.jar -DgroupId=com.github.yukihane.rjava -DartifactId=jri-engine -Dversion=0.1.0-SNAPSHOT -Dpackaging=jar \
&& mvn install:install-file -Dfile=/usr/local/lib/R/site-library/rJava/jri/REngine.jar -DgroupId=com.github.yukihane.rjava -DartifactId=r-engine -Dversion=0.1.0-SNAPSHOT -Dpackaging=jar
