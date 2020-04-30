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

RUN export JAVA_HOME=/root/.sdkman/candidates/java/current \
&& R CMD javareconf \
&& R CMD BATCH <(echo "install.packages('rJava')")
