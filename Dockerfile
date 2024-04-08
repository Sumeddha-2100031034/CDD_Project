# Use the official Nginx image as the base image
FROM nginx:alpine

# Copy the HTML file into the Nginx default public directory
COPY *.html /usr/share/nginx/html/
