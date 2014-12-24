cd /var/www

# remove repo if it already exists
rm -rf playing; true

# install latest nodejs server
git clone http://github.com/pphanireddy/playing playing
cd playing
npm install

node index.js
