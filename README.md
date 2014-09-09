BeReplaced
==========

A Bukkit plugin to assist plugin testing by replacing the old plugin file with the new plugin file and reload the server automatically.

Usage
----------

Clone the repository, build it with Maven, and put the jar in your plugins/ directory. Run the server once to let the plugin generate config.yml. Once the config.yml is generated, you can edit it to add plugins that need to be replaced(Remember to reload the server to make the changes take effect! ). Then when you use /ber command in game or in the console, BeReplaced will copy all files you specified in config.yml and if you already have files with the same name in your plugins/ folder, they are replaced.

An example of config.yml:

    pluginPaths:
      - /path/to/file.jar

If you have this config.yml, when you type /ber, BeReplaced will copy the path/to/file.jar to your plugins/ folder and this operation will override the original file in plugins/ folder if you have one.
