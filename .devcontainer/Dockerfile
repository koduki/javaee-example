# Use Payara Server Full as the base image
ARG PAYARA_VERSION_TAG=5.2022.5
FROM payara/server-full:${PAYARA_VERSION_TAG}

USER root

# Install prerequisites for VSCode devcontainer, Maven, and other tools
RUN apt-get update && apt-get install -y --no-install-recommends \
    ca-certificates \
    curl \
    gnupg \
    wget \
    unzip \
    sudo \
    git \
    vim \
    software-properties-common \
    && rm -rf /var/lib/apt/lists/*

# Install Java 25
ARG JAVA_VERSION=25
RUN wget https://download.oracle.com/java/25/latest/jdk-25_linux-x64_bin.tar.gz -P /tmp && \
    mkdir -p /opt/java && \
    tar xf /tmp/jdk-25_linux-x64_bin.tar.gz -C /opt/java && \
    rm /tmp/jdk-25_linux-x64_bin.tar.gz && \
    ln -s /opt/java/jdk-25 /opt/java/current
ENV JAVA_HOME=/opt/java/current
ENV PATH=${JAVA_HOME}/bin:${PATH}

# Install Maven
ARG MAVEN_VERSION=3.9.6
RUN wget https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
    rm /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Create a non-root user 'vscode' for development
ARG USERNAME=vscode
# 'vscode' ユーザーとホームディレクトリを作成し、sudo 権限を付与
RUN useradd -m -s /bin/bash ${USERNAME} && \
    echo "${USERNAME} ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers.d/${USERNAME} && \
    chmod 0440 /etc/sudoers.d/${USERNAME}

# Payara Server の標準ディレクトリの権限を vscode ユーザーに合わせる
# Payara の標準ディレクトリ構成を利用し、必要な権限のみ調整
RUN chown -R ${USERNAME}:${USERNAME} /opt/payara/

# Switch to vscode user
USER ${USERNAME}
WORKDIR /home/${USERNAME}

# Verify Java and Maven versions (optional, for debugging during build)
RUN java -version
RUN mvn -version