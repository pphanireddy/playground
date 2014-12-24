FROM pphanireddy/nodejs

# add startup script and start the script
RUN mkdir /var/www
ADD start.sh /var/www/
RUN chmod +x /var/www/start.sh
CMD ./var/www/start.sh
