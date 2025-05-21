FROM mcr.microsoft.com/devcontainers/java:21-bookworm

USER root

# Install prerequisites for adding custom repositories and for Payara
RUN apt-get update && apt-get install -y --no-install-recommends \
    ca-certificates \
    curl \
    gnupg \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Install Maven
ARG MAVEN_VERSION=3.9.6
RUN wget https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
    rm /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Download and install Payara Server
ARG PAYARA_VERSION=6.2023.12
ARG PAYARA_HOME=/opt/payara6
RUN wget https://repo1.maven.org/maven2/fish/payara/distributions/payara-community/${PAYARA_VERSION}/payara-community-${PAYARA_VERSION}.zip -P /tmp && \
    unzip /tmp/payara-community-${PAYARA_VERSION}.zip -d /opt && \
    mv /opt/payara6* ${PAYARA_HOME} && \
    rm /tmp/payara-community-${PAYARA_VERSION}.zip

# Switch back to vscode user (or create if not present in base, though devcontainer images usually have it)
# The base image mcr.microsoft.com/devcontainers/java:bookworm should have a vscode user.
USER vscode

# Verify Java version (optional, for debugging)
# RUN java -version
# RUN mvn -version

# Default command to keep container running if needed,
# but for devcontainer, VS Code manages the lifecycle.
# CMD ["sleep", "infinity"]
