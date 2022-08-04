# IntelliJ-Plugin-Spotify

A simple plugin for IntelliJ that allows you to listen to Spotify music control it and other features.

## Spotify API Usage
This Plugin uses the [Spotify API](https://developer.spotify.com/documentation/web-api/) to interact with your Spotify account. Therefore I used the [Spotify Java wrapper/client](https://github.com/spotify-web-api-java/spotify-web-api-java) which is [officially supported by Spotify](https://developer.spotify.com/documentation/web-api/libraries/).

## Warning
To use this plugin, you need to have a Spotify account and sign up for a developer account. You can sign up for a developer account [here](https://developer.spotify.com/dashboard/).

Please note that your password and other personal information will only be Base64 encoded and stored in the plugin. This means that your personal information will be visible to anyone who has access to the plugin.
Dont share your personal information with anyone!

## How to use the plugin
1. If you dont have a Spotify account, you can sign up for one [here](https://www.spotify.com/de/signup).
2. Go to Spotify [Developer Dashboard](https://developer.spotify.com/dashboard) and create a new application. Maybe you have to login again.
3. Copy the client ID and client secret to the plugin.
4. Paste the client ID and client secret in the plugin.
5. Press the "Einloggen" button.
6. You should now be logged in to Spotify. And the plugin should now be able to interact with your Spotify account.

Note: On your Spotify Dashboard you can see the interactions with your account.