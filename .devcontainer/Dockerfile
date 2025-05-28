# Use Payara Server Full as the base image
ARG PAYARA_VERSION_TAG=5.2022.5
FROM payara/server-full:${PAYARA_VERSION_TAG}

# Payara server is installed at /opt/payara5 by the base image.
# Switch to root to install tools, then create 'vscode' user.
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
    software-properties-common \
    && rm -rf /var/lib/apt/lists/*

# Install Temurin JDK 8
# This assumes the base Payara image is Debian-based and /etc/os-release is available.
# RUN if [ -f /etc/os-release ] && grep -q VERSION_CODENAME /etc/os-release; then \
#         OS_RELEASE_PATH="/etc/os-release"; \
#     elif [ -f /usr/lib/os-release ]; then \
#         OS_RELEASE_PATH="/usr/lib/os-release"; \
#     else \
#         echo "Warning: Cannot determine OS version for Adoptium repository. Skipping Temurin JDK 8 installation." && exit 0; \
#     fi && \
#     curl -fsSL https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor -o /usr/share/keyrings/adoptium.gpg && \
#     echo "deb [signed-by=/usr/share/keyrings/adoptium.gpg] https://packages.adoptium.net/artifactory/deb $(awk -F= '/^VERSION_CODENAME=/{print$2}' $OS_RELEASE_PATH) main" | tee /etc/apt/sources.list.d/adoptium.list && \
#     apt-get update && \
#     apt-get install -y temurin-8-jdk && \
#     rm -rf /var/lib/apt/lists/*

# Set JAVA_HOME to Temurin JDK 8
# ENV JAVA_HOME=/usr/lib/jvm/temurin-8-jdk-amd64
# Ensure this JAVA_HOME is preferred. Add it to the beginning of PATH.
# ENV PATH=${JAVA_HOME}/bin:${PATH}

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
# RUN java -version
# RUN mvn -version

# The devcontainer will manage the lifecycle.
# Payara server can be started using a postCreateCommand in devcontainer.json, e.g.,
# "/opt/payara5/bin/asadmin start-domain domain1"
# For devcontainer, often better to let it be started by user or post-create script.
# CMD ["sleep", "infinity"]
