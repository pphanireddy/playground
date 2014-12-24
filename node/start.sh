cd /var/www

# remove repo if it already exists
rm -rf playing; true

# install latest nodejs server
git clone https://github.com/pphanireddy/playground.git
cd playground/node
npm install
node index.js
