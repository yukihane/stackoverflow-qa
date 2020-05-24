FROM node:10.17.0-alpine3.9
WORKDIR /zatubako
COPY package*.json ./
RUN npm install
RUN npm install --save @vue/cli-service
CMD ["npm", "run", "serve"]
