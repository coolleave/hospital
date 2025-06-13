import request from '@/utils/request'

// 查询肝功能生化指标列表
export function listBiochemistry(query) {
  return request({
    url: '/system/biochemistry/list',
    method: 'get',
    params: query
  })
}

// 查询肝功能生化指标详细
export function getBiochemistry(Id) {
  return request({
    url: '/system/biochemistry/' + Id,
    method: 'get'
  })
}

// 新增肝功能生化指标
export function addBiochemistry(data) {
  return request({
    url: '/system/biochemistry',
    method: 'post',
    data: data
  })
}

// 修改肝功能生化指标
export function updateBiochemistry(data) {
  return request({
    url: '/system/biochemistry',
    method: 'put',
    data: data
  })
}

// 删除肝功能生化指标
export function delBiochemistry(Id) {
  return request({
    url: '/system/biochemistry/' + Id,
    method: 'delete'
  })
}
// 新增：根据 encounterId 查询生命体征
export function listBiochemistryByEncounterId(encounterId) {
  return request({
    url: '/system/biochemistry/list2',
    method: 'get',
    params: { encounterId }
  })
}