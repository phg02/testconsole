package controller;

import model.Host;

import java.util.HashSet;

public interface HostManagerController {
    HashSet<Host> getAllHosts();
    Host getHostByID(String hostId);
    HashSet<Host> getHostByFullName(String fullName);
    Host getHostByContactInformation(String contactInformation);
    boolean addHost(Host host);
    boolean updateHost(Host host);
    boolean deleteHost(String hostId);
}
