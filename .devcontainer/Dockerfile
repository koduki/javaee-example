FROM mcr.microsoft.com/devcontainers/java:bookworm

USER root

# Install prerequisites for adding custom repositories and for Payara
RUN apt-get update && apt-get install -y --no-install-recommends \
    ca-certificates \
    curl \
    gnupg \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Add Adoptium repository and install Temurin JDK 8
RUN curl -fsSL https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor -o /usr/share/keyrings/adoptium.gpg && \
    echo "deb [signed-by=/usr/share/keyrings/adoptium.gpg] https://packages.adoptium.net/artifactory/deb $(awk -F= '/^VERSION_CODENAME=/{print$2}' /etc/os-release) main" | tee /etc/apt/sources.list.d/adoptium.list && \
    apt-get update && \
    apt-get install -y temurin-8-jdk && \
    rm -rf /var/lib/apt/lists/*

# Set JAVA_HOME to Temurin JDK 8
ENV JAVA_HOME=/usr/lib/jvm/temurin-8-jdk-amd64

# Install Maven
ARG MAVEN_VERSION=3.9.6
RUN wget https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
    rm /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${PATH}

# Download and install Payara Server
ARG PAYARA_VERSION=5.2022.5
ARG PAYARA_HOME=/opt/payara5
RUN wget https://repo1.maven.org/maven2/fish/payara/distributions/payara/${PAYARA_VERSION}/payara-${PAYARA_VERSION}.zip -P /tmp && \
    unzip /tmp/payara-${PAYARA_VERSION}.zip -d /opt && \
    rm /tmp/payara-${PAYARA_VERSION}.zip
RUN chown -R vscode /opt/payara5/
# Switch back to vscode user (or create if not present in base, though devcontainer images usually have it)
# The base image mcr.microsoft.com/devcontainers/java:bookworm should have a vscode user.
USER vscode

# Verify Java version (optional, for debugging)
# RUN java -version
# RUN mvn -version

# Default command to keep container running if needed,
# but for devcontainer, VS Code manages the lifecycle.
# CMD ["sleep", "infinity"]
