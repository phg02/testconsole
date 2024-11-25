package controller.impl;

import controller.HostManagerController;
import model.Host;
import util.FileHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class HostManagerImpl implements HostManagerController {
    private HashSet<Host> hosts;
    private FileHandler fileHandler;

    public HostManagerImpl(FileHandler fileHandler) {
       this.fileHandler = fileHandler;
        hosts = this.fileHandler.getHostData();
    }

    @Override
    public HashSet<Host> getAllHosts() {
        return hosts;
    }

    @Override
    public Host getHostByID(String hostId) {
        return hosts.stream().filter(host -> host.getId().equals(hostId)).findFirst().orElse(null);
    }

    @Override
    public HashSet<Host> getHostByFullName(String fullName) {
        return (HashSet<Host>) hosts.stream().filter(host -> host.getFullName().equals(fullName)).collect(Collectors.toSet());
    }

    @Override
    public Host getHostByContactInformation(String contactInformation) {
        return hosts.stream().filter(host -> host.getContactInformation().equals(contactInformation)).findFirst().orElse(null);
    }

    @Override
    public boolean addHost(Host host) {
        return false;
    }

    @Override
    public boolean updateHost(Host host) {
        return false;
    }

    @Override
    public boolean deleteHost(String hostId) {
        return false;
    }
}
