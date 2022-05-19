# 
FROM debian:latest

# apt Install/Update
RUN apt update && apt upgrade -y
RUN apt-get install sudo
RUN sudo apt-get install debconf
RUN sudo apt update && sudo apt upgrade -y

RUN sudo apt-get install apt-utils
RUN sudo apt update && sudo apt upgrade -y

RUN sudo apt install apt-transport-https ca-certificates gnupg2 curl git -y
RUN sudo apt install wget
RUN sudo wget -O- https://repo.jellyfin.org/jellyfin_team.gpg.key | gpg --dearmor | sudo tee /usr/share/keyrings/jellyfin.gpg
RUN echo "deb [arch=$( dpkg --print-architecture ) signed-by=/usr/share/keyrings/jellyfin.gpg] https://repo.jellyfin.org/debian bullseye main" | sudo tee /etc/apt/sources.list.d/jellyfin.list
RUN sudo apt update && sudo apt upgrade -y

RUN sudo apt install jellyfin -y
RUN sudo apt update && sudo apt upgrade -y

RUN sudo apt-get -y install systemctl

CMD ["systemctl", "start", "jellyfin"]

# Port 
EXPOSE 8096

